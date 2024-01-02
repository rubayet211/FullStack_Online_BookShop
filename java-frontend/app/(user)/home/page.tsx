'use client'
import { Button, Label, TextInput } from 'flowbite-react';
import { CiSearch  } from 'react-icons/ci';
import { useEffect } from 'react';
import BookCards from '@/app/components/Books/BookCards';
import { useAuth } from '@/app/contexts/AuthContext';
import { useCookies } from 'next-client-cookies';

export default function Home() {
    const {get, set, remove} = useCookies()
    const {isLoggedin, login, SetUsername, username} = useAuth()
    
    if(get('id') !== undefined) 
    {
        login();
        
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
