import { Component } from '@angular/core';
import { NavbarTop } from '../navbar-top/navbar-top';

@Component({
  selector: 'app-home',
  imports: [NavbarTop],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {}
