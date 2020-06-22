using CombatCavallers.cops;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace CombatCavallers.Lluitador
{
    /// <summary>
    /// Crea un lluitador que fa servir el cop il·legal i com a mínim sempre es protegeix el cap
    /// aleatòria
    /// </summary>
    class LluitadorTrampos : ILluitador
    {
        private readonly Random rnd;
        private readonly List<LlocOnPicar> copsPossibles;

        public LluitadorTrampos(string nom)
        {
            rnd = new Random(Guid.NewGuid().GetHashCode());
            copsPossibles = Enum.GetValues(typeof(LlocOnPicar)).Cast<LlocOnPicar>().ToList();
            Nom = nom;
        }

        public string Nom { get; }
        public int Forca { get; set; } = 1;

        public LlocOnPicar Pica()
        {
            int index = rnd.Next(copsPossibles.Count);
            return copsPossibles[index];
        }

        public IEnumerable<LlocOnPicar> Protegeix()
        {
            var punts = Enum.GetValues(typeof(LlocOnPicar)).Cast<LlocOnPicar>();
            var noProtegir = (LlocOnPicar)rnd.Next(Enum.GetValues(typeof(LlocOnPicar)).Cast<LlocOnPicar>().Where(r => r != LlocOnPicar.Cap).ToList().Count);
            return punts.Where(val => val != noProtegir).ToArray();
        }
    }
}
