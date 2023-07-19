import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PropertyComponent } from './property/property.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { ProprtyMainComponent } from './proprty-main/proprty-main.component';
import { AgentComponent } from './agent/agent.component';
import { AllagentComponent } from './allagent/allagent.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { CrouselComponent } from './crousel/crousel.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { FeaturedPropertyComponent } from './featured-property/featured-property.component';
import { ScheduleTourComponent } from './schedule-tour/schedule-tour.component';
import { ContactComponent } from './contact/contact.component';
import { ConsultantComponent } from './consultant/consultant.component';
import { WishListComponent } from './wish-list/wish-list.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ForgotpassComponent } from './forgotpass/forgotpass.component';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RentComponent } from './rent/rent.component';
import { FilterComponent } from './filter/filter.component';
import {LoginAdminComponent} from './login-admin/login-admin.component';
import { AgentLoginComponent } from './agent-login/agent-login.component'






@NgModule({
  declarations: [
    AppComponent,
    PropertyComponent,
    LoginComponent,
    SignupComponent,
    ProprtyMainComponent,
    AgentComponent,
    AllagentComponent,
    FooterComponent,
    HomeComponent,
    HeaderComponent,
    CrouselComponent,
    AboutUsComponent,
    FeaturedPropertyComponent,
    ScheduleTourComponent,
    ContactComponent,
    ConsultantComponent,
    WishListComponent,
    ForgotpassComponent,
    RentComponent,
    FilterComponent,
    LoginAdminComponent,
    AgentLoginComponent

  
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatDatepickerModule
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
