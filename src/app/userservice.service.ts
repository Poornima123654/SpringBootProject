import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UserserviceService {



  constructor(private httpclient:HttpClient) { }

getUserData(username: string,password: string)
{
  return this.httpclient.get('http://localhost:8080/user/'+username+'/'+password);
}

}
