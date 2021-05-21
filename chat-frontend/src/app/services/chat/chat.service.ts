import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

const url = 'http://localhost:9092/api/chatmessages';

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  message: string | undefined;
  token = localStorage.getItem('token');
  requestOptions = {
    headers: new HttpHeaders( {
      Authorization: `Bearer ${this.token}`
    })
  };

  constructor(private http: HttpClient) { }

  getMessages() {
    return this.http
      .get(`${url}`, this.requestOptions);
  }

  sendChatMessage(chatMessage: any) : any {
    return this.http
      .post(`${url}`, chatMessage , this.requestOptions);
  }

  deleteChatMessage(chatMessageId: any) : any {
    return this.http
      .delete(`${url}/${chatMessageId}`, this.requestOptions)
  }

  updateChatMessage(chatMessageId: any) : any {
    return this.http
      .put(`${url}/${chatMessageId}`, this.requestOptions);
  }
}
