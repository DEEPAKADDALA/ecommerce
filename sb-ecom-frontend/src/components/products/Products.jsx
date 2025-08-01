import { useEffect } from "react";
import ProductCard from "../shared/ProductCard";
import { FaExclamationTriangle, FaSpinner } from "react-icons/fa";
import{useDispatch, useSelector} from "react-redux";
import { fetchCategories, fetchProducts } from "../../store/actions";
import Filter from "./Filter";
import Paginations from "../shared/Paginations";
import useProductFilter from "../../hooks/useProductFilter";

const Products = () => {
    const{isLoading,errorMessage}=useSelector(
        (state)=>state.errors
    )
    const {products,categories,pagination}=useSelector(
        (state)=>state.products
    )
    const dispatch =useDispatch();

    useProductFilter()
    useEffect(()=>{
        dispatch(fetchCategories());
    },[dispatch])

    return (
        <div className="lg:px-14 sm:px-8 px-4 py-14 2xl:w-[90%] 2xl:mx-auto">
            <Filter categories={categories? categories:[]}/>
            {
                isLoading ? (
                    <div className="flex justify-center items-center h-[200px]">
                        <FaSpinner className="text-4xl text-blue-500 animate-spin mr-2" />
                        <span className="text-slate-800 text-lg font-medium">
                            Loading... Please wait 
                        </span>
                    </div>
                ) : errorMessage ? (
                    <div className="flex justify-center items-center h-[200px]">
                        <FaExclamationTriangle className="text-4xl text-red-500 mr-2" />
                        <span className="text-slate-800 text-lg font-medium">
                            {errorMessage}
                        </span>
                    </div>
                ) : products.length === 0 ? (
                    <div className="flex flex-col justify-center items-center h-[200px]">
                        <FaExclamationTriangle className="text-4xl text-gray-500 mb-4" />
                        <span className="text-slate-800 text-lg font-medium">
                            No products available
                        </span>
                    </div>
                ) : (
                    <div className="min-h-[700px]">
                        <div className="pb-6 pt-14 grid 2xl:grid-cols-5 lg:grid-cols-4 sm:grid-cols-3 gap-y-6 gap-x-6">
                            {products.map((item, i) => (
                                <ProductCard key={i} {...item} />
                            ))}
                        </div>
                        <div className="flex justify-center items-center p-4">
                        <Paginations
                        numberOfPages={pagination?.totalPages}
                        totalProducts={pagination?.totalElements}/>
                        </div>
                    </div>
                )
            }
        </div>
    );
}

export default Products;