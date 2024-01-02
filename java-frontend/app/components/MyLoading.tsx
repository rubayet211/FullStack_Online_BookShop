import { Spinner } from "flowbite-react"

const MyLoading = () => {
  return (
    <div className="flex flex-col text-center gap-3 mt-5">
            <Spinner color="failure" size="xl" />
            <p className="font-bold">Loading.....</p>
    </div>
  )
}
export default MyLoading