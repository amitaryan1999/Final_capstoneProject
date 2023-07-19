import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { PropertyComponent } from './property/property.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { LoginComponent } from './login/login.component';
import { FeaturedPropertyComponent } from './featured-property/featured-property.component';
import { FooterComponent } from './footer/footer.component';
import { ContactComponent } from './contact/contact.component';
import { ProprtyMainComponent } from './proprty-main/proprty-main.component';
import { SignupComponent } from './signup/signup.component';
import { ForgotpassComponent } from './forgotpass/forgotpass.component';
import { RentComponent } from './rent/rent.component';
import { WishListComponent } from './wish-list/wish-list.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { AgentLoginComponent } from './agent-login/agent-login.component';


const routes: Routes = [
  { path:"", redirectTo:'home', pathMatch: 'full' },
  { path:'header',component:HeaderComponent},
  { path:'home', component: HomeComponent },
  { path:'property', component: PropertyComponent},
  { path:'aboutus', component: AboutUsComponent },
  { path:'login', component: LoginComponent },
  { path:'home', component: HomeComponent },
  { path:'featured-property', component: FeaturedPropertyComponent},
  { path:'proprty-main/:id', component: ProprtyMainComponent},
  { path:'footer', component: FooterComponent },
  { path:'contact', component: ContactComponent },
  { path:'signup', component: SignupComponent },
  { path:'forgotpass', component: ForgotpassComponent },
  { path:'rent', component: RentComponent },
  { path:'wishlist',component:WishListComponent},
  {path:'admin-login',component:LoginAdminComponent},
  {path:'agent-login', component:AgentLoginComponent}







];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
