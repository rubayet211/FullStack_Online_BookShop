'use client'
import { useRouter } from "next/navigation"
import { useEffect } from "react"
import MyLoading from "./components/MyLoading"


const page = () => {
  const router = useRouter()
  useEffect(()=>{
    router.push('/home')
  })
  return (
    <MyLoading />
  )
}
export default page