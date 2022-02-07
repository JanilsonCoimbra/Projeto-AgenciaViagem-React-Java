import styles from './BtnFloat.module.css'
import { store } from '../stores/store'
import { useEffect, useState } from 'react'


function BtnFloat() {
    const [stat, setState] = useState(false)

    function openCadastro() {
        if(stat){
            store.dispatch({ type: false })
            setState(false)
        }else{
            store.dispatch({ type: true })
            setState(true)
        }
        
    }

    useEffect(() =>{
        store.subscribe(()=>{
            setState(store.getState())
        })
    },[])
    return (<>
       <div onClick={openCadastro} className={styles.btn}><img src='./img/aviao.png'></img></div>

    </>)
}
export default BtnFloat