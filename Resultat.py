from ILluitador import ILluitador


class IResultat:

    def get_nom(self) -> str:
        """retorna el nom del lluitador."""
        pass

    def get_vida(self) -> int:
        """retorna la vida del lluitador."""
        pass

    def es_Ko(self) -> bool:
        """Retorna si el lluitador està derrotat"""
        pass

    def esta_eliminat(self) -> bool:
        """Determina si el lluitador està eliminat"""
        pass

    def Elimina(self):
        """ Elimina el lluitador"""
        pass

    def __str__(self):
        return self.get_nom() + "(" + str(self.get_vida()) + ")"


class ICombatents(IResultat):

    def get_Lluitador(self) -> ILluitador:
        """Retorna el lluitador"""
        pass

    def treu_vida(self, quanta : int) -> int:
        """Treu vida del lluitador i retorna la que li queda"""
        pass


class Resultat(ICombatents):

    def __init__(self, lluitador, vida):
        self._Lluitador = lluitador
        self._Vida = vida
        self._Eliminat = False

    def get_nom(self) -> str:
        return self._Lluitador.get_nom()

    def get_vida(self):
        return self._Vida

    def es_Ko(self) -> bool:
        return self._Vida <= 0

    def get_Lluitador(self) -> ILluitador:
        return self._Lluitador

    def treu_vida(self, quanta: int) -> int:
        self._Vida = self._Vida - quanta
        return self._Vida

    def esta_eliminat(self) -> bool:
        return self._Eliminat

    def Elimina(self):
        self._Eliminat = True