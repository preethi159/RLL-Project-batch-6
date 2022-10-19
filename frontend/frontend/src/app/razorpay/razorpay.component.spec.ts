import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { RazorpayComponent } from './razorpay.component';

describe('RazorpayComponent', () => {
  let component: RazorpayComponent;
  let fixture: ComponentFixture<RazorpayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RazorpayComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RazorpayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(RazorpayComponent);
    const razorpay = fixture.componentInstance;
    expect(razorpay).toBeTruthy();
  });

  it(`should have as title 'Payment'`, () => {
    const fixture = TestBed.createComponent(RazorpayComponent);
    const razorpay = fixture.componentInstance;
    expect(razorpay.title).toEqual('Payment');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(RazorpayComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain('Payment app is running!');
  });
});