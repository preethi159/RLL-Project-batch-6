import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindAllFoodComponent } from './find-all-food.component';

describe('FindAllFoodComponent', () => {
  let component: FindAllFoodComponent;
  let fixture: ComponentFixture<FindAllFoodComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindAllFoodComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FindAllFoodComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
