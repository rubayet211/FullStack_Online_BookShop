import type { Metadata } from 'next'
import Navbar from '../../components/Navbar';

export const metadata: Metadata = {
    title: 'LiBook | Cart',
    description: 'An online book library',
}


export default function DashboardLayout({
    children, 
  }: {
    children: React.ReactNode
  }) {
    return (
        <>
            <div className="w-4/5 mx-auto mt-3 p-3">
                <div>
                    <p className='text-xl '>Your Cart 
                    </p>
                    <hr className="border-1 border-gray-700"/>
                </div>
            
                {children}
            </div>
        </>
    )
  }