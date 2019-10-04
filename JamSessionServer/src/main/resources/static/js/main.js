'use strict';

var nameInput = $('#name');
var roomInput = $('#room-id');
var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var connectingElement = document.querySelector('.connecting');
var roomIdDisplay = document.querySelector('#room-id-display');

var stompClient = null;
var currentSubscription;
var username = null;
var sessionId = null;
var topic = null;
var playingSounds = [];

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
  username = nameInput.val().trim();
  Cookies.set('name', username);
  if (username) {
    usernamePage.classList.add('hidden');
    chatPage.classList.remove('hidden');

    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    //for debug remove this
    stompClient.debug = null;
    stompClient.connect({}, onConnected, onError);
  }
  event.preventDefault();
}

// Leave the current session and enter a new one.
function enterSession(newSessionId) {
  sessionId = newSessionId;
  Cookies.set('sessionId', sessionId);
  roomIdDisplay.textContent = sessionId;
  topic = `/app/jamsession/${newSessionId}`;

  if (currentSubscription) {
    currentSubscription.unsubscribe();
  }
  currentSubscription = stompClient.subscribe(`/jamsession/${sessionId}`, onMessageReceived);

  stompClient.send(`${topic}/addUser`,
    {},
    JSON.stringify({sender: username, type: 'JOIN'})
  );
}

function onConnected() {
  enterSession(roomInput.val());
  connectingElement.classList.add('hidden');
}

function onError(error) {
  connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
  connectingElement.style.color = 'red';
}

function onMessageReceived(payload) {
  var message = JSON.parse(payload.body);

  var messageElement = document.createElement('li');

 if (message.type == 'SOUND') {
    messageElement.classList.add('event-message');
    message.content = message.instrument + ' ' + message.tune;
    var playSound = new sound('1.mp3');
    playSound.play();
  }
}

$(document).ready(function() {
  var savedName = Cookies.get('name');
  if (savedName) {
    nameInput.val(savedName);
  }

  var savedRoom = Cookies.get('sessionId');
  if (savedRoom) {
    roomInput.val(savedRoom);
  }

  usernamePage.classList.remove('hidden');
  usernameForm.addEventListener('submit', connect, true);
});

document.addEventListener('keydown', function(event) {
  if (event.code == 'KeyG') {
    var soundMessage = {
      instrument: 'KEYBOARD',
      tune: 'C',
      type: 'SOUND',
      play:'true'
    };
    stompClient.send(`${topic}/sendSoundMessage`, {}, JSON.stringify(soundMessage));
  }
});

/*document.addEventListener('keyup', function(event) {
  if (event.code == 'KeyG') {
    var soundMessage = {
      instrument: 'KEYBOARD',
      tune: 'C',
      type: 'SOUND',
      play:'false'
    };
    stompClient.send(`${topic}/sendSoundMessage`, {}, JSON.stringify(soundMessage));
  }
});*/

//sound stuff

function sound(src) {
  this.sound = document.createElement("audio");
  this.sound.src = src;
  this.sound.setAttribute("preload", "auto");
  this.sound.setAttribute("controls", "none");
  this.sound.style.display = "none";
  document.body.appendChild(this.sound);
  this.play = function(){
    this.sound.play();
  }
  this.stop = function(){
    this.sound.pause();
  }
}


