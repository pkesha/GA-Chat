import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

const url = 'http://localhost:9092/api/messages';

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

  sendMessage(chatMessage: any) : any {
    const token = localStorage.getItem('token');
    const request
  }
}
