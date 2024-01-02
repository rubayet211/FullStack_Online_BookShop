'use client'
import { ReactNode, createContext, useContext, useState } from "react";

type authContextType = {  
    isLoggedin: boolean;
    username: string;
    userId: number;
    SetUserId: (UserId:number) => void;
    SetUsername: (Username:string) => void;
    login: () => void;
    logout: () => void;
};

const authContextDefaultValues: authContextType = { 
    isLoggedin: false,
    username: 'shamim',
    userId: -1,
    SetUserId: (UserId:number) => {},
    SetUsername: (Username:string) => {},
    login: () => {},
    logout: () => {},
};

const AuthContext = createContext<authContextType>(authContextDefaultValues);

export function useAuth() {
    return useContext(AuthContext);
}

type Props = {
    children: ReactNode;
};

export function AuthProvider({ children }: Props) {
    const [isLoggedin, setUser] = useState(false)
    const [userId, setUserId] = useState(-1)
    const [username, setUsername] = useState('shamim')

    const SetUserId = (UserId:number)=>{
        setUserId(UserId);
    }
    const login = () => {
        setUser(true);
    };

    const SetUsername = (Username:string) => {
        setUsername(Username);
    }

    const logout = () => {
        setUser(false);
    };

    const value = {
        username,
        userId,
        SetUserId,
        SetUsername,
        isLoggedin,
        login,
        logout,
    };
    return (
        <>
            <AuthContext.Provider value={value}>
                {children}
            </AuthContext.Provider>
        </>
    );
}