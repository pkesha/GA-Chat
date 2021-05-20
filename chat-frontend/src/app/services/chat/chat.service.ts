import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

const url = 'http://localhost:9092/api/messages';

@Injectable({
  providedIn: 'root'
})
export class ChatService {
  message: string | undefined;

  constructor(private http: HttpClient) { }

  getMessages() {
    const token = localStorage.getItem('token');
    const requestOptions = {
      headers: new HttpHeaders( {
        Authorization: `Bearer ${token}`
      })
    };

    return this.http
      .get(`${url}`, requestOptions);
  }
}
