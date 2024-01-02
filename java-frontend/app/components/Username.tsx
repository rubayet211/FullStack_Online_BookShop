import Link from "next/link"
import { useAuth } from '@/app/contexts/AuthContext';

const Username = () => {
    const { isLoggedin, username } = useAuth()
  return (
    <Link href='/profile' className="px-2 rounded bg-orange-300 hover:bg-orange-400 hover:cursor-pointer">{username}</Link>
  )
}
export default Username