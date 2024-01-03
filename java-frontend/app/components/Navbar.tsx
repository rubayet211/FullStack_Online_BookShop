'use client'
import { FaBookReader } from "react-icons/fa";
import Link from "next/link";
import { FaCartArrowDown } from "react-icons/fa";
import { useAuth } from "../contexts/AuthContext";
import Logo from "./Logo";
import Username from "./Username";


const Navbar = () => {
  const { isLoggedin, username } = useAuth()
  return (
    <nav className="bg-sky-300 flex p-4 justify-between w-full font-semibold">
        <Logo />
        <div className="ml-36">
          <ul className="flex gap-16 uppercase tracking-widest">
            <li className="hover:text-orange-400 hover:cursor-pointer">
              <Link href='/home'>Home</Link>
            </li>
            <li className="hover:text-orange-400 hover:cursor-pointer">
              <Link href='/about'>About</Link>
            </li>
            <li className="hover:text-orange-400 hover:cursor-pointer">
              <Link href='/contact'>Contact</Link>
            </li>
          </ul>
        </div>
        <div className="flex gap-3">
          <Link href='/cart'>
            <FaCartArrowDown className='text-2xl hover:cursor-pointer hover:text-orange-400 mr-3'/>
          </Link>
          {isLoggedin ? 
          
            (
              <>
                <Username />
              </>
            )
            :
            (
              <>
              <Link href='/login' className="px-2 rounded bg-orange-300 hover:bg-orange-400 hover:cursor-pointer">Login</Link>
              <Link href='/register' className="px-2 rounded bg-orange-300 hover:bg-orange-400 hover:cursor-pointer">Register</Link>
              </>
            )
            
          }
        </div>
    </nav>
  )
}
export default Navbar