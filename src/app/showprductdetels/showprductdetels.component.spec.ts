import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowprductdetelsComponent } from './showprductdetels.component';

describe('ShowprductdetelsComponent', () => {
  let component: ShowprductdetelsComponent;
  let fixture: ComponentFixture<ShowprductdetelsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowprductdetelsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShowprductdetelsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
