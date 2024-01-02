import type { Metadata } from 'next'
import Navbar from '../components/Navbar'
import MyFooter from '../components/MyFooter'


export const metadata: Metadata = {
    title: 'LiBook',
    description: 'An online book library',
}


export default function DashboardLayout({
    children, 
  }: {
    children: React.ReactNode
  }) {
    return (
      <>
        <Navbar />
        <section>   
          {children}
        </section>
        <MyFooter />
      </>
    )
  }