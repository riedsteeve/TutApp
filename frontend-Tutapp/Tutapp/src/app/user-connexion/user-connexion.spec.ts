import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserConnexion } from './user-connexion';

describe('UserConnexion', () => {
  let component: UserConnexion;
  let fixture: ComponentFixture<UserConnexion>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserConnexion],
    }).compileComponents();

    fixture = TestBed.createComponent(UserConnexion);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
