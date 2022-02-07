import styles from './Cards.module.css'
function Cards(props) {
    return (
        <>
            <div className={styles.tamanho}>
                <div className="card">
                    <div className="card-image waves-effect waves-block waves-light">
                        <img className="activator" src={props.img} />
                    </div>
                    <div className="card-content" data-aos="flip-left"
                    data-aos-easing="ease-out-cubic"
                    data-aos-duration="1000">
                        <span className="card-title activator grey-text text-darken-4">{props.title}<i className="material-icons right">more_vert</i></span>
                        <p><a href="#">Ver mais</a></p>
                    </div>
                    <div className="card-reveal">
                        <span className="card-title grey-text text-darken-4">Card Title<i className="material-icons right">close</i></span>
                        <p>{props.informacoes}</p>
                    </div>
                </div>

            </div>
        </>
    )
}
export default Cards