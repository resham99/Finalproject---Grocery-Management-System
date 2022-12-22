import { Router, RouterModule } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import {GrocessaryService} from '../service/grocessary.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private router:Router,
    private gservice:GrocessaryService) { }

  ngOnInit(): void {
  }
  viewall():void{
    console.log("test");

if (this.gservice.getClientAuthorization() !== null){
  this.router.navigate(["/client/home"])

}else{
  this.router.navigate(["/client-login"])

}

  }

}