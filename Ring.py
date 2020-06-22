import random
from random import randint
from IRing import *
from ILluitador import ILluitador
from Resultat import *
from typing import List
from llocOnPicar import LlocOnPicar


class Ring(IRing):

    VIDAINICIAL = 20

    def EntradaLluitadors(self, lluitador1, lluitador2):
        """Els dos lluitadors entren al Ring"""
        primer = Resultat(lluitador1, Ring.VIDAINICIAL)
        segon = Resultat(lluitador2, Ring.VIDAINICIAL)
        self._Lluitadors = [primer, segon]
        self.copsIlegals = [0, 0]

    def Lluiteu(self) -> IResultList:
        """Combat entre els dos lluitadors"""

        if len(self._Lluitadors) != 2:
            print("ERROR. Falten lluitadors")
            exit

        self.copsIlegals = [0, 0]

        elQuePica = randint(0, 1)

        while self._Lluitadors[0].es_Ko() == False and self._Lluitadors[0].esta_eliminat() == False and self._Lluitadors[1].es_Ko() == False and self._Lluitadors[1].esta_eliminat() == False:

            elQueRep = (elQuePica+1) % 2
            proteccio = self._Lluitadors[elQueRep].get_Lluitador().Protegeix()
            _, pica = self._Lluitadors[elQuePica].get_Lluitador().Pica()

            efecteSobreDefensor = 0
            efecteSobreAtacant = 0
            missatge = ""
            ostiaDoble = random.randint(0, 1)
            if pica in [LlocOnPicar.CAP, LlocOnPicar.COSTATESQUERRA, LlocOnPicar.COSTATDRET, LlocOnPicar.PANXA]:
                efecteSobreDefensor = 1 + ostiaDoble
                efecteSobreAtacant = 0
                missatge = f'{self._Lluitadors[elQueRep].get_nom()} ({self._Lluitadors[elQueRep].get_vida()}) rep un cop al {pica.name} de {self._Lluitadors[elQuePica].get_nom()} ({self._Lluitadors[elQuePica].get_vida()})'
            elif pica == LlocOnPicar.ILEGAL:
                efecteSobreDefensor = 1 + ostiaDoble
                efecteSobreAtacant = 0
                missatge = f'{self._Lluitadors[elQueRep].get_nom()} ({self._Lluitadors[elQueRep].get_vida()}) rep un cop ILEGAL de {self._Lluitadors[elQuePica].get_nom()} ({self._Lluitadors[elQuePica].get_vida()})'
            else:
                missatge = "Esperant ..."

            if pica in proteccio or pica == LlocOnPicar.ILEGAL:
                self._Lluitadors[elQueRep].treu_vida(efecteSobreDefensor)
                self._Lluitadors[elQuePica].treu_vida(efecteSobreAtacant)
                missatge = missatge + " Ostia doble!!!!" if ostiaDoble else missatge
                print(missatge)
            else:
                missatge = f'{self._Lluitadors[elQueRep].get_nom()} atura el cop al {pica.name} de {self._Lluitadors[elQuePica].get_nom()}'
                missatge = missatge + " Ostia doble!!!!" if ostiaDoble else missatge
                if ostiaDoble:
                    efecteSobreAtacant = 1
                    self._Lluitadors[elQuePica].treu_vida(efecteSobreAtacant)
                print(missatge)
            if pica == LlocOnPicar.ILEGAL:
                self.copsIlegals[elQuePica] = self.copsIlegals[elQuePica] + 1
                if self.copsIlegals[elQuePica] == 3:
                    self._Lluitadors[elQuePica].Elimina()
                    break

            elQuePica = elQueRep

        guanyador = next(x for x in self._Lluitadors if x.es_Ko()
                         == False and x.esta_eliminat() == False)
        perdedor = next(i for i in self._Lluitadors if i.es_Ko()
                        == True or i.esta_eliminat() == True)

        comentariLocutor = ""

        if (perdedor.esta_eliminat()):
            comentariLocutor = f"{perdedor.get_nom()} està ELIMINAT per cops ilegals"
        else:
            print(f"{perdedor.get_nom()} cau a terra!")

            if (guanyador.get_vida() - perdedor.get_vida()) > 5:
                comentariLocutor = "Quina pallissa!!"

        print(f"VICTÒRIA DE {guanyador.get_nom()}!!! {comentariLocutor}")

        return self._Lluitadors
