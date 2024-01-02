'use client'
import Image from 'next/image'
import { useRouter } from 'next/navigation';

const MySidebar = () => {
  const router = useRouter()
  return (
    <div className='w-1/5 bg-gray-600 flex flex-col text-center font-bold text-white'>
            <div className='w-full mt-4 font-bold'>
                <div className="h-32 w-32 relative rounded-full object-none object-[59%_-4px] bg-gray-100 border-4 border-orange-400 mx-auto">
                      <Image
                          src="/admin.png"
                          alt="Picture of admin"
                          fill={true}
                          />
                </div>
                <p className='mt-2 text-center text-white'>Shamim Ahmed</p>
                <p className='text-center text-orange-300'>Admin</p>
            </div>
            <div className='p-3 mt-4 border-y hover:bg-gray-700 hover:cursor-pointer' onClick={()=>router.push('/dashboard')}>
              Dashboard
            </div>
            <div className='p-3 hover:bg-gray-700 hover:cursor-pointer' onClick={()=>router.push('/books')}>
              Books
            </div>
            <div className='p-3 border-y hover:bg-gray-700 hover:cursor-pointer' onClick={()=>router.push('/customers')}>
              Customers
            </div>
            <div className='text-black mt-auto w-full bg-orange-300 hover:bg-orange-400 hover:cursor-pointer p-3 uppercase '>
              Logout
            </div>
    </div>
  );
}


export default MySidebar