'use client'
import type { Metadata } from 'next'
import Image from 'next/image'
import { useRouter } from 'next/navigation'
import MySidebar from '../components/MySidebar'
import { usePathname } from 'next/navigation'
import Logo from '../components/Logo'
import Username from '../components/Username'

// export const metadata: Metadata = {
//     title: 'LiBook | Authentication',
//     description: 'An online book library',
// }


export default function DashboardLayout({
    children, 
  }: {
    children: React.ReactNode
  }) {
    const router = useRouter()
    const pathname = usePathname()

    let tabname = pathname.split('/')[1]

    return (
      <section className='w-full h-screen flex'>
            <MySidebar />
           
           <div className='w-4/5 overflow-auto'>
              <div className='flex justify-between px-4 py-2 '>
                <Logo />
                <Username />
              </div>

              <div className='uppercase bg-gray-600 p-1 font-bold text-white text-center sticky top-0 z-50'>{tabname}</div>

              <div className='p-4'>
                {children}
              </div>
           </div>
      </section>
    )
  }