import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewfoodUserComponent } from './viewfood-user.component';

describe('ViewfoodUserComponent', () => {
  let component: ViewfoodUserComponent;
  let fixture: ComponentFixture<ViewfoodUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewfoodUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewfoodUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
