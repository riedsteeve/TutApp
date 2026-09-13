import { Component, signal } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-user-create-account',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './user-create-account.html',
  styleUrl: './user-create-account.css',
})
export class UserCreateAccount {
  isLoading = signal(false);

  createAccountForm = new FormGroup({
    nom:new FormControl('', Validators.required),
    prenom: new FormControl('', Validators.required),
    email:new FormControl('',[Validators.required, Validators.email]),
    mdp:new FormControl('',[Validators.required, Validators.minLength(8)]),
    confirmMdp:new FormControl('',Validators.required),
    username:new FormControl('', Validators.required)
  });

  onSubmit(){
    if(this.createAccountForm.valid){
      this.isLoading.set(true);
      console.log(this.createAccountForm.value);
    }
  }

}
