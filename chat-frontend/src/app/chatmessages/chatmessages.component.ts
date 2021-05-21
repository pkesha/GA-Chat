import {Component, Input, OnInit, Output, EventEmitter} from '@angular/core';
import {ChatService} from "../services/chat/chat.service";

@Component({
  selector: 'app-chatmessages',
  templateUrl: './chatmessages.component.html',
  styleUrls: ['./chatmessages.component.css']
})
export class ChatmessagesComponent implements OnInit {
  @Input() message : any;

  @Output() deleteItemEvent = new EventEmitter<any>();

  constructor(private chatService: ChatService) { }

  ngOnInit(): void {
  }

  deleteMessage(chatMessageId: number): void {
    this.chatService.deleteChatMessage(chatMessageId)
      .subscribe(response => {
        console.log(response + "message id " + chatMessageId);
        this.deleteItemEvent.emit();
      });
  }

  updateMessage(chatMessageId: number): void {
    this.chatService.updateChatMessage(chatMessageId)
      .subscribe(response => {
        console.log(response + " chat id " + chatMessageId);
        this.deleteItemEvent.emit();
      });
  }

}
