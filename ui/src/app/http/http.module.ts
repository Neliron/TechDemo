import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from '../app.component';



@NgModule({
  declarations: [ AppComponent ],
  exports: [ AppComponent ],
  imports: [
    CommonModule,
    HttpClientModule
  ]
})
export class HttpModule { }
