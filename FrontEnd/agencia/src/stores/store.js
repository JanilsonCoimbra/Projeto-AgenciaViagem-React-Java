import { createStore } from "redux"
import openMenu from "../reducer/openMenu"

const store = createStore(openMenu)
export {store}