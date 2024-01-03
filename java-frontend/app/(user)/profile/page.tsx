'use client'
import secureLocalStorage from 'react-secure-storage';
import { useRouter } from 'next/navigation';
import { useAuth } from '@/app/contexts/AuthContext';
import { mutate } from 'swr';
const page = () => {
    const router = useRouter()
    const {logout} = useAuth()
  return (
    <div className="mt-10 text-center">
        <span className="bg-orange-300 px-4 py-2 hover:bg-orange-400 hover:cursor-pointer rounded" onClick={()=>{
            secureLocalStorage.removeItem('email')
            secureLocalStorage.removeItem('password')
            logout()
            window.location.replace("/home");
        }}>Logout</span>
    </div>

  )
}
export default page