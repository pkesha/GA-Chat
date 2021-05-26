import {Component, OnInit} from '@angular/core';
import {ChatService} from "../../services/chat/chat.service";
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-chatbox',
  templateUrl: './chatbox.component.html',
  styleUrls: ['./chatbox.component.css']
})
export class ChatboxComponent implements OnInit {
  // @ts-ignore
  subscription: Subscription;
  // @ts-ignore
  public chatMessages: [];
  public currentUserMessagesDb: [] | undefined;
  public otherUsersMessagesDb: [] | undefined;
  public message: string | undefined;
  public interval: any | undefined;

  constructor(private chatService: ChatService) {
  }

  ngOnInit(): void {
    if (this.chatMessages === null) {

    } else {
      this.getChatMessages();

      if (!localStorage.getItem('currentUser')) {
        alert('<span> Need to login first! </span>');
      }
    }

    this.getChatMessages();
    this.interval = setInterval(() => {
      this.getChatMessages();
    }, 1000);
  }

  getChatMessages(): void {
    this.chatService.getMessages()
      .subscribe(messages => {
        // @ts-ignore
        this.chatMessages = messages;
        console.log(this.chatMessages);
      });

  }

  sendMessage(): any {
    let timeSent = new Date();
    timeSent.getDate();
    timeSent.getTime();
    timeSent.getHours();
    timeSent.getMinutes();
    timeSent.getSeconds();

    let newChatMessage: any = {
      message: this.message,
      date: timeSent
    };

    this.chatService.sendChatMessage(newChatMessage)
      .subscribe((response: any) => {
        console.log(response);
        this.getChatMessages();
      }, () => {
        alert('Invalid input or too many requests!');
    });
  }
}
