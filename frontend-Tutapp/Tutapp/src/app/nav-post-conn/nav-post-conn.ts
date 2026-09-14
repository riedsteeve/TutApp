import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-nav-post-conn',
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './nav-post-conn.html',
  styleUrl: './nav-post-conn.css',
})
export class NavPostConn {
  userMenuOpen = false;

  toggleUserMenu(): void {
    this.userMenuOpen = !this.userMenuOpen;
  }
}