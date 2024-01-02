const DashboardCards = ({value, title}:{value: number, title: string}) => {
  return (
    <div className="bg-white rounded-xl grid grid-cols-1 content-center h-60 text-center font-bold text-2xl hover:cursor-pointer hover:text-orange-400 min-w-max">
          <p className="text-6xl">{value}</p>
          <p className="mt-auto">{title}</p>
    </div>
  )
}
export default DashboardCards