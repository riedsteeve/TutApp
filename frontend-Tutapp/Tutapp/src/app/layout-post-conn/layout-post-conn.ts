import { Component } from '@angular/core';
import { NavPostConn } from '../nav-post-conn/nav-post-conn';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-layout-post-conn',
  imports: [RouterOutlet, NavPostConn],
  templateUrl: './layout-post-conn.html',
  styleUrl: './layout-post-conn.css',
})
export class LayoutPostConn {}
