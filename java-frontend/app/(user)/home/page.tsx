'use client'
import { Button, Label, TextInput } from 'flowbite-react';
import { CiSearch  } from 'react-icons/ci';
import { useEffect } from 'react';
import BookCards from '@/app/components/Books/BookCards';
import { useAuth } from '@/app/contexts/AuthContext';
import { useCookies } from 'next-client-cookies';
import secureLocalStorage from 'react-secure-storage';
import useSWR, { mutate } from 'swr';
import MyLoading from '@/app/components/MyLoading';
import axios from 'axios';

const link = "http://localhost:8081/signin";
const fetcher = (link:string) => axios.post(link).then(res => res.data)


export default function Home() {
  const email = secureLocalStorage.getItem('email') as string;
  const password = secureLocalStorage.getItem('password') as string;
  
  const { data, error, isLoading } = useSWR(link, () => axios.post(link, {
    email: email,
    password: password
  }).then(res => res.data));

    console.log(data)
    const {SetUsername,isLoggedin, SetUserId, login,logout} = useAuth()
    
    
    if(data)
    {
        SetUsername(email)
        login()
    }else 
    {
      logout()
    }
  return (
    <>
    
    <main className="flex flex-col gap-4 w-4/5 mx-auto p-4">
      <div className='mx-auto w-1/2'>
          <TextInput type="text" icon={CiSearch } placeholder="search books here" />
      </div>
      <div>
        <p className='text-xl '>Latest Books 
        </p>
        <hr className="border-1 border-gray-700"/>
      </div>

      <BookCards />

    </main>
    </>
  )
}
