package cl.ejercicios.calculadordesueldos

abstract class Empleado(montoBruto: Double) {
    var sueldoBruto = montoBruto;

    abstract fun calcularLiquido():Double
}

class EmpleadoHonorarios(montoBruto: Double):Empleado(montoBruto){
    override fun calcularLiquido():Double {
        return sueldoBruto*0.87
    }
}

class EmpleadoRegular(montoBruto: Double):Empleado(montoBruto){
    override fun calcularLiquido():Double {
        return sueldoBruto*0.8
    }
}