'use client'
import Navbar from "@/app/components/Navbar"
import { useAuth } from "@/app/contexts/AuthContext"
import axios from "axios";
import { Button, Checkbox, Label, TextInput } from 'flowbite-react';
import { useCookies } from "next-client-cookies";
import { useRouter } from "next/navigation";
import { useState } from "react";
import secureLocalStorage from "react-secure-storage";



const Login = () => {
  const {SetUsername, SetUserId, login} = useAuth()
  const endPoint = "http://localhost:8081/signin"
  // const endPoint = "http://localhost:3333/login"
  const [email, setEmail] = useState("")
  const [password, setPassword] = useState("")
  const router = useRouter()
  const {get, set, remove} = useCookies()
  const onSubmit = async (e:any)=>{
    e.preventDefault()
    if(email === "" || password === "")
    {
      alert("Please fill all the fields")
      return
    }

    axios.post(endPoint, {
      email: email,
      password: password
    })
      .then(function (response) {
        secureLocalStorage.setItem('email', email); 
        secureLocalStorage.setItem('password', password);
       
        console.log(response)
        router.push('/home')
      })
      .catch(function (error) {
        alert("Invalid email or password")
        console.log(error);
      });

    
  }
  return (
    <>
      <form className="flex max-w-md flex-col gap-4 bg-white p-4 rounded mx-auto mt-16 ">
        <div>
          <div className="mb-2 block">
            <Label htmlFor="email1" value="Your email" />
          </div>
          <TextInput value={email} onChange={(e)=>setEmail(e.target.value)} id="email1" type="email" placeholder="name@email.com" required />
        </div>
        <div>
          <div className="mb-2 block">
            <Label htmlFor="password1" value="Your password" />
          </div>
          <TextInput value={password} onChange={(e)=>setPassword(e.target.value)} type="password" required />
        </div>
        
        <Button onClick={onSubmit} type="submit">Login</Button>
        <Button onClick={()=>router.push('register')} type="submit" color="dark">Register</Button>
    </form>

    </>
  )
}
export default Login