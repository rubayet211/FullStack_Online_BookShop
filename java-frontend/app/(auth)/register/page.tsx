"use client";
import Navbar from "@/app/components/Navbar";
import { Label, TextInput, Checkbox, Button, Select, Datepicker, Alert } from "flowbite-react";
import Image from 'next/image'
import { useEffect, useState } from "react";
import Link from 'next/link';
import axios from "axios";

const Registration = () => {
  const link = "http://localhost:8081/register";
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [password, setPassword] = useState("");
  const [dob, setDob] = useState("");
  const [gender, setGender] = useState("");
  const [notification, setNotification] = useState(false);

  const onSubmit = (e:any)=>{
      e.preventDefault()
      if(name==""||email==""||phone==""||password==""||dob==""||gender==""){
        alert('Please fill all fields')
        return
      }

      

      axios.post(link, {
        "user": {
          "email": email,
          "password": password
        },
        "userDetail": {
          "name": name,
          "phone": phone,
          "dob": dob,
          "gender": gender
        }
      })
      .then(function (response) {
        console.log(response);
        setName("")
        setEmail("")
        setPhone("")
        setPassword("")
        setDob("")
        setGender("")
        setNotification(true)
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  return (
    <>

    {notification && (<Alert className="mx-auto w-2/3 mt-3" color="success" withBorderAccent onDismiss={()=>setNotification(false)}>
      <span>
        <span className="font-medium">Successfully registered! </span> Please <Link href="/login" className="font-bold underline hover:text-sky-600">login</Link> to continue shopping.
      </span>
    </Alert>)}
      <div className="flex justify-between w-1/2   rounded mx-auto mt-8 mb-4">
        <div className="w-1/2 relative">
          <Image
            src="/bookstore-image.jpg"
            alt="Picture of Book Store"
            fill={true}
          />
        </div>

        <form className="w-1/2 flex flex-col p-4 gap-3 bg-white">
          
            <div className="mb-1">
              
              <TextInput 
              onChange={(e)=>setName(e.target.value)} 
              value={name}
              placeholder="name" sizing="sm" id="name" type="text" required />
              
            </div>

            <div className="mb-1">
              <TextInput 
              onChange={(e)=>setEmail(e.target.value)} 
              value={email}
              placeholder="email" sizing="sm" id="email" type="email" required />
            </div>

            <div className="mb-1">
              <TextInput 
              onChange={(e)=>setPhone(e.target.value)} 
              value={phone}
              placeholder="phone" sizing="sm"  id="phone" type="text" required />
            </div>

            <div>
              <TextInput 
              onChange={(e)=>setPassword(e.target.value)} 
              value={password}
              placeholder="password" sizing="sm" id="password" type="password" required />
            </div>

            <div>
              <div className="mb-1 block">
                <Label htmlFor="dob" value="Date of birth" />
              </div>
              <TextInput
                onChange={(e)=>setDob(e.target.value)}
                value={dob}
                id="dob"
                type="date"
                required
                sizing="sm"
              />
            </div>

            <div className="max-w-md mb-1">
              <div className="mb-1 block">
                <Label htmlFor="gender" value="Select your gender" />
              </div>
              <Select 
              onChange={(e)=>setGender(e.target.value)} 
              value={gender}
              sizing="sm" id="gender" required>
                <option>Male</option>
                <option>Female</option>
              </Select>
            </div>
          
          <Button onClick={onSubmit} type="submit">Register</Button>
        </form>
      </div>
    </>
  );
};
export default Registration;
