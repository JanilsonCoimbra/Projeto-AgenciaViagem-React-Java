import styles from './Cadastro.module.css'
import { useParams, useSearchParams} from 'react-router-dom'
import { Suspense } from 'react/cjs/react.production.min'

function Cadastro(props) {

  return (<>
    <section className={styles.cadastro}>
      <header className={styles.headerBox}>Box de informações</header>
            <Suspense fallback={<h1>Rota 5</h1>}>
                <h1>Perguntas Frequentes</h1>
                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Reiciendis nisi ullam tenetur nobis nam cumque laudantium corrupti sequi non, vitae assumenda eius alias. Eum dolore soluta distinctio! Natus, iure inventore.</p>
            </Suspense>
    </section>
    
  </>)
}
export default Cadastro