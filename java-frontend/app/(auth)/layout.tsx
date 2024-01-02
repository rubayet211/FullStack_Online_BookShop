import type { Metadata } from 'next'
import Navbar from '../components/Navbar'


export const metadata: Metadata = {
    title: 'LiBook | Authentication',
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
      </>
    )
  }