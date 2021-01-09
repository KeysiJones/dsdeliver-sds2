export type Product = {
    id: number;
    name: string;
    price: number;
    description: string;
    imageUri: string;
}

export type OrderLocationData = {
    latitude: number
    longitude: number
    address: string
}

type ProductId = {
    id: number;
}

//Order payload é um merge de OrderPayload + OrderLocationData
export type OrderPayload = {
    products: ProductId[];
} & OrderLocationData;