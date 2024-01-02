import type { Metadata } from 'next'
import { Inter } from 'next/font/google'
import './globals.css'
import { AuthProvider, useAuth } from './contexts/AuthContext'
import NavbarDefault from './components/Navbar'
import MyFooter from './components/MyFooter'
import Navbar from './components/Navbar'
import { AppProvider, useApp } from './contexts/ApplicationContext'
import { CookiesProvider } from 'next-client-cookies/server';

export const metadata: Metadata = {
  title: 'LiBook',
  description: 'An online book library',
}

const inter = Inter({ 
  subsets: ['latin'],
  display: 'swap',
 })

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <CookiesProvider>

      <AppProvider>
        <AuthProvider>
        <html lang="en" className={inter.className}>
          <body className='bg-sky-200 flex flex-col min-h-screen'>
            {children}
          </body>
        </html>
        </AuthProvider>
      </AppProvider>
    </CookiesProvider>

  )
}
