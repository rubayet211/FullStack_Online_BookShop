'use client'
import { Button, Spinner } from "flowbite-react"
import { useApp } from "../contexts/ApplicationContext"
import { use, useEffect } from "react"
import axios from "axios"
import { useCookies } from 'next-client-cookies';


const Test = () => {
  const {get, set, remove} = useCookies()
  
  useEffect(()=>{
    set('shamim', 'new cookie')
  },[])
  return (
    <>
    {get('shamim')}
    </>
  )
}
export default Test