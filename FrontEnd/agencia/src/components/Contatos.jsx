import styles from './Contatos.module.css'
function Contatos() {
    return (<>
        <section className={styles.contatos}>
            <form className='row'>
                <div className="mb-3 col-11">
                    <label for="exampleInputname" className="form-label">Nome</label>
                    <input type="name" className="form-control" id="exampleInputname" />
                </div>
                <div className="mb-3 col-11">
                    <label for="exampleInputname" className="form-label">Nome</label>
                    <input type="email" className="form-control" id="exampleInputname" />
                </div>
                <div className="mb-3 col-11">
                    <label for="exampleInputEmail1" className="form-label">Mensagem</label>
                    <textarea className="form-text" id="exampleCheck1" />
                </div>
                <button type="submit" className="btn btn-primary col-11">Submit</button>
            </form>
        </section>
    </>)
}
export default Contatos