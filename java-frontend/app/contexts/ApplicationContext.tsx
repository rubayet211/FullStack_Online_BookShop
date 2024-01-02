'use client'

import { ReactNode, createContext, useContext, useState } from "react";

type ApplicationContextType = {  
    navbar: boolean;
    SetNavbar: (bool:boolean)  => void;
};

const appContextDefaultValues: ApplicationContextType = { 
    navbar: false,
    SetNavbar: (bool:boolean) => {}
};

const AppContext = createContext<ApplicationContextType>(appContextDefaultValues);

export function useApp() {
    return useContext(AppContext);
}

type Props = {
    children: ReactNode;
};

export function AppProvider({ children }: Props) {
    const [navbar, setNavbar] = useState(false)
    const SetNavbar = (bool:boolean) => {
        setNavbar(bool);
    }
    

    const value = {
        navbar,
        SetNavbar,
    };
    return (
        <>
            <AppContext.Provider value={value}>
                {children}
            </AppContext.Provider>
        </>
    );
}