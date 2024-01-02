import { useRouter } from "next/navigation"
import { FaBookReader } from "react-icons/fa"

const Logo = () => {
    const router = useRouter()
  return (
    
    <div className="hover:cursor-pointer" onClick={()=>router.push('/home')}>
        <p className="flex gap-1 text-xl font-bold hover:text-orange-400">
            <FaBookReader className='text-2xl text-orange-400' />
            LiBook
        </p>
    </div>
    
  )
}
export default Logo