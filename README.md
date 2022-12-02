# stbs
Hello Sam Pattuzzi please find out code for mesagging application. it uses Firebase Firestore & Authentication fully written in kotlin.


## Login Screen

<img width="261" alt="Login Screen invalid pwd" src="https://user-images.githubusercontent.com/111985843/205372057-21a4716f-0383-4c1a-8d75-de779336c440.png"><img width="259" alt="Email Already Used" src="https://user-images.githubusercontent.com/111985843/205372935-43a9c181-aba1-4df5-aeaf-ad9042d2f8dd.png">

## Chat List Screen

After succesful sign up or log in chat list will be displayed which can be considered as the main screen. You can send a new message to a new user or eigther continue a previous conversation. You also have the configuration button which will redirect you to the settings screen.

<img width="416" alt="Chat List" src="https://user-images.githubusercontent.com/111985843/205375100-ee94a2b4-8d65-44fc-a0eb-8354487034a1.png">

## Settings Screen

On the setting screen you can manage your account,when you click on change password, you'll receive a mail with instructions to change your account.

<img width="418" alt="Settings" src="https://user-images.githubusercontent.com/111985843/205376647-de3d80d2-9435-4187-869e-c2e7bcca890a.png"><img width="415" alt="Settings Change pwd" src="https://user-images.githubusercontent.com/111985843/205376614-698e671d-6771-48f2-a2f2-c189aaa259cf.png">

<img width="881" alt="Reset pwd mail" src="https://user-images.githubusercontent.com/111985843/205380431-85e6d762-ca64-49b3-b7b3-a006ec4a0452.png">

when you click on sign out, your account will be closed and you will be sent back to login screen.

## Chat Screen

On the chat screen you can see messages you sent and the ones sended by the other device. Your messages will be aligned to the right and the other device messages will be aligned to the left. You can also navigate to the chat list screen by clicking the back button.

<img width="411" alt="Chat First Device" src="https://user-images.githubusercontent.com/111985843/205375733-bb50589f-560c-4145-a3cf-ff293da46efa.png"><img width="407" alt="Chat Second Device" src="https://user-images.githubusercontent.com/111985843/205375764-02c101dd-ae4a-4068-a682-9fa60c90363a.png">

## New Chat

You can start a new conversation from chat list screen. just input other person mail and click start. You can also send messages to non-enrolled people. When they create their account your messages will come up.

<img width="417" alt="New Chat" src="https://user-images.githubusercontent.com/111985843/205376951-ae2de359-a70c-43c5-a32c-c5804ea6414e.png"> <img width="412" alt="New Chat messages" src="https://user-images.githubusercontent.com/111985843/205376973-1dd2912b-d2fe-4bb0-9bae-3b9c7d53c5dd.png">

## Firebase Authentication

all account will be registered on firebase. we can also handle the users there like add, remove or change properties

<img width="1610" alt="Firebase Authentication" src="https://user-images.githubusercontent.com/111985843/205381192-4b0463c2-38f8-4817-ae45-1f88e9957cb6.png">

## Firebase Firestore

On firestore we are saving everything that is being send over the app, Like the users, messages, chats and details about them.

#### Chats collection

we have to basic collections, one for the chats that will store the chats with a unique ID and inside that collection, we have another collection which stores all messages sent with information like the message, date and user.

<img width="1611" alt="Firestore Chat main" src="https://user-images.githubusercontent.com/111985843/205381534-079b4f34-e5ac-46bb-8754-e0382feb95bd.png"> <img width="1612" alt="Firestore Chat Messages" src="https://user-images.githubusercontent.com/111985843/205381546-d33f60e6-5141-4518-bff2-9e40e05c3cfa.png">

#### Users Collection

On the users collection we are storing all user conversations, so inside that collection we have a collection that stores all chats from that user with a unique ID and information like the name and the users involved.

<img width="1612" alt="Firestore Users Main" src="https://user-images.githubusercontent.com/111985843/205382333-f338d45a-f516-44a4-aa9c-e024804ed6e4.png"><img width="1612" alt="FireStore Users conversations" src="https://user-images.githubusercontent.com/111985843/205382401-6347b638-1dce-4a04-b9f5-de88c36c4280.png">



Any doubt feel free to reach out for me 


